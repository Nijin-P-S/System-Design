# WebSocket Broadcast Demo (Spring Boot)

This project is a simple demonstration of **server-to-client communication using WebSockets** in Spring Boot.

The goal is to understand how a backend can **push updates to connected clients** when something changes on the server.

---

## What this does

- Establishes a WebSocket connection between browser and server
- Keeps track of connected clients
- Broadcasts messages to all clients
- Triggers WebSocket messages via a REST API call

---

## How it works

1. Browser opens `index.html`
2. A WebSocket connection is created to `/ws`
3. The server stores the active WebSocket session
4. A REST API (`POST /update-status`) is called
5. The service layer simulates a DB update
6. The server broadcasts a message to all connected clients

---

## Why WebSockets

With HTTP, the client must keep polling the server for updates.

WebSockets keep a **persistent connection**, allowing the server to push messages instantly.  
This is useful for notifications, live updates, and real-time systems.

---

## Current implementation note

For simplicity, the WebSocket handler uses a **static session store** to manage connected clients.

This is:
- Easy to understand
- Fine for learning and demos

⚠️ **In production**, WebSocket session management should be handled using **Spring-managed beans**, and scaled setups should use a **Pub/Sub system (Redis, Kafka, etc.)**.

---

## How to test

1. Start the application
2. Open `http://localhost:8080/` in multiple tabs
3. Call:
   ```bash
   curl -X POST http://localhost:8080/update-status
4. All open tabs will receive a message

## Why this project exists

### This repo focuses on:

- Understanding WebSocket fundamentals

- Clean separation between REST (state change) and WebSocket (notifications)

- Real-world backend patterns in a minimal setup
