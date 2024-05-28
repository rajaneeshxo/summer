package io.rjnsh.summer.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOPractice {
    private static final String SCATTER_GATHER_FILE_PATH = "./src/main/resources/nio/header-body";
    private static final String SCATTER_GATHER_OUT_FILE_PATH = "./src/main/resources/nio/header-body-out";
    public static void main(String... args) throws IOException {
        // channelPractice();
        // scatterAndGather();
        transferBetweenChannels();
    }

    static void channelPractice() throws IOException {
        // streams are one way, channels are both ways
        // every operation is from the point of view of a channel
        // can be done asynchronously, read data from a channel into a buffer, write data to a channel from a buffer
        // channel types: FileChannel, DatagramChannel, SocketChannel, ServerSocketChannel
        
        // open a channel to an io bound resource
        RandomAccessFile file = new RandomAccessFile("./raf", "rw");
        
        FileChannel fileChannel = file.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);
        
        // read into channel from buffer
        // buffers have modes, read and write, so for this operation, it is in write mode
        int bytesRead = fileChannel.read(buf);
        while (bytesRead != -1) {
            System.out.println("read number of bytes " + bytesRead);
            // flip the mode of the buffer to read, limit of the buffer is current position
            // sets the position of the buffer to 0 so that it can be read
            buf.flip();

            while (buf.hasRemaining()) {
                // read byte by byte
                System.out.println((char) buf.get());
            }

            // clear the buffer for the next operation
            buf.clear();
            bytesRead = fileChannel.read(buf);
        }

        buf.clear();

        file.close();

        // allocate a buffer, create a file channel
        // write into buffer via channel
        // flip  and read from buffer -> flip sets the position of the buffer to 0 and limits the size of the buffer to the current length of the buffer
    }

    static void scatterAndGather() throws IOException {
        // assuming the message has header and body, we can use different buffers to operate on the same
        final ByteBuffer HEAD_BUF = ByteBuffer.allocate((int) (1e2));
        final ByteBuffer BODY_BUF = ByteBuffer.allocate((int) (1e3));

        ByteBuffer[] buffers = {HEAD_BUF, BODY_BUF};
        RandomAccessFile raf = new RandomAccessFile(SCATTER_GATHER_FILE_PATH, "r");
        FileChannel fileChannel = raf.getChannel();
        // scatter read and only works when the sequence of bytes if fixed as the size of allocated buffers
        fileChannel.read(buffers);
        // this won't work for dynamically sized messages or channel reads
    
        // saving the content of both the buffers to some other file
        // but gathering works fine for messages of dynamic size

        RandomAccessFile outFile = new RandomAccessFile(SCATTER_GATHER_OUT_FILE_PATH, "rw");
        FileChannel outChannel = outFile.getChannel();

        for (ByteBuffer buf : buffers) {
            buf.flip();
        }

        // buffers have data
        outChannel.write(buffers);

        outFile.close();
        raf.close();
    }

    static void transferBetweenChannels() throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile(SCATTER_GATHER_FILE_PATH, "r");
        FileChannel fromChannel = fromFile.getChannel();
        

        RandomAccessFile toFile = new RandomAccessFile(SCATTER_GATHER_OUT_FILE_PATH, "rw");
        FileChannel toChannel = toFile.getChannel();
        long position = 0;
        long limit = fromChannel.size();

        fromChannel.transferTo(position, limit, toChannel);
    }

    
}
