🚀 Multi-Threaded Chat Application in Java
📚 Description
This project is a simple multi-threaded chat application implemented in Java. It demonstrates how to build a server that can handle multiple clients simultaneously, allowing all clients to communicate in a shared chat room environment. The core of this application revolves around Java sockets, multi-threading, and stream-based I/O, providing a solid foundation for understanding how basic networked applications work.

⚙️ How It Works
🖥️ Server (Server.java)
The server listens on port 1234 for incoming client connections.

When a new client connects, the server:

Accepts the connection.

Creates a new ClientHandler thread dedicated to this client.

Adds the client to a set of active connections.

Each ClientHandler listens for messages from its client and broadcasts them to all other connected clients.

If a client disconnects or an error occurs, the server removes it from the active list and cleans up resources.

Key highlights:
✅ Multi-threaded: handles multiple clients concurrently.
✅ Broadcast system: sends each client’s message to all other connected clients.
✅ Clean removal and resource management when clients disconnect.

💬 Client (Client.java)
The client connects to the server on localhost:1234.

It spawns:

A ReadThread to continuously listen for messages from the server and display them.

A WriteThread to read user input from the console and send it to the server.

This design ensures the client can both send and receive messages in real time without blocking.

Key highlights:
✅ Two threads handle input & output simultaneously.
✅ Simple console-based interface.
✅ Handles server disconnects gracefully.

🔍 Detailed Explanation
When the application runs:

The server starts first, waiting for clients on port 1234.

A client connects, and the server logs this new connection and starts a dedicated handler thread.

The client sends messages typed in the console, which the server receives and broadcasts to all other connected clients.

The other clients print the message, creating a shared chat room effect.

If a client disconnects, the server notices, removes it from the active set, and logs the event.

This project offers hands-on experience with:

Java sockets for TCP communication.

Multi-threaded programming to handle multiple connections in parallel.

Buffered I/O streams (BufferedReader & PrintWriter) for efficient text-based data exchange.

Basic server-client architecture, which is foundational for more advanced systems like multiplayer games, collaborative editors, or real-time messaging apps.

✨ Why is this useful?
🧠 Helps understand the building blocks of network programming in Java.

🚀 Demonstrates practical multi-threading and concurrent client handling.

🔥 Lays groundwork for creating more advanced chat systems, with authentication, private messaging, or GUI frontends.

🛠️ Getting Started
✅ To run the server:
bash
Copy
Edit
javac Server.java
java Server
✅ To run the client (open multiple terminals to simulate multiple clients):
bash
Copy
Edit
javac Client.java
java Client
Then type messages in the client consoles. They’ll be broadcast to all other connected clients.

🎯 Conclusion
This multi-threaded chat system is a straightforward yet powerful demonstration of real-world networking concepts using Java. It shows how multiple clients can interact with each other through a single server, all managed via threads and simple socket communication.
