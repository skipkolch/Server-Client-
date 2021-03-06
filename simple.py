import socket

server_socket = socket.socket()
server_socket.bind(('', 80))

server_socket.listen(10)

print("Server start\n")

while True:
    client_socket, remote_address = server_socket.accept();

    try:
        request = client_socket.recv(1024);
        client_socket.send(request.upper());
        print('{} : {}'.format(client_socket.getpeername(), request))
        client_socket.close();
    except:
        pass

server_socket.close()
