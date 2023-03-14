package com.example.g38_offloading;

import java.io.*;

public class DataConversionSerial {

    public static byte[] objectToByteArray(Object object) throws IOException {
        //this function converts object to byte array
        byte[] bytes = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {

            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

            objectOutputStream.writeObject(object);
            objectOutputStream.flush();

            bytes = byteArrayOutputStream.toByteArray();

        } finally {
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
        }
        return bytes;
    }


    public static Object byteArrayToObject(byte[] bytes) throws IOException, ClassNotFoundException {
        //convert byte array to object
        Object object = null;
        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {

            byteArrayInputStream = new ByteArrayInputStream(bytes);
            objectInputStream = new ObjectInputStream(byteArrayInputStream);

            object = objectInputStream.readObject();

        } catch (Exception exc) {

            System.out.println("Exception on converting Byte Array to Object in CacheDeserializer with Exception{}" + exc);

        } finally {

            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }

            if (objectInputStream != null) {
                objectInputStream.close();
            }
        }
        return object;
    }

}
