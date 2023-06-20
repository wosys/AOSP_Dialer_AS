// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: packages/apps/Dialer/java/com/fissy/dialer/rtt/rtt_transcript.proto

package com.wintmain.dialer.rtt;

public interface RttTranscriptOrBuilder extends
        // @@protoc_insertion_point(interface_extends:com.fissy.dialer.rtt.RttTranscript)
        com.google.protobuf.MessageLiteOrBuilder {

    /**
     * <pre>
     * Unique ID used for database.
     * </pre>
     *
     * <code>optional string id = 1;</code>
     */
    boolean hasId();

    /**
     * <pre>
     * Unique ID used for database.
     * </pre>
     *
     * <code>optional string id = 1;</code>
     */
    java.lang.String getId();

    /**
     * <pre>
     * Unique ID used for database.
     * </pre>
     *
     * <code>optional string id = 1;</code>
     */
    com.google.protobuf.ByteString
    getIdBytes();

    /**
     * <pre>
     * Phone number of RTT call.
     * </pre>
     *
     * <code>optional string number = 2;</code>
     */
    boolean hasNumber();

    /**
     * <pre>
     * Phone number of RTT call.
     * </pre>
     *
     * <code>optional string number = 2;</code>
     */
    java.lang.String getNumber();

    /**
     * <pre>
     * Phone number of RTT call.
     * </pre>
     *
     * <code>optional string number = 2;</code>
     */
    com.google.protobuf.ByteString
    getNumberBytes();

    /**
     * <pre>
     * Timestamp when the RTT call is created.
     * </pre>
     *
     * <code>optional int64 timestamp = 3;</code>
     */
    boolean hasTimestamp();

    /**
     * <pre>
     * Timestamp when the RTT call is created.
     * </pre>
     *
     * <code>optional int64 timestamp = 3;</code>
     */
    long getTimestamp();

    /**
     * <pre>
     * Chat messages.
     * </pre>
     *
     * <code>repeated .com.fissy.dialer.rtt.RttTranscriptMessage messages = 4;</code>
     */
    java.util.List<com.wintmain.dialer.rtt.RttTranscriptMessage>
    getMessagesList();

    /**
     * <pre>
     * Chat messages.
     * </pre>
     *
     * <code>repeated .com.fissy.dialer.rtt.RttTranscriptMessage messages = 4;</code>
     */
    com.wintmain.dialer.rtt.RttTranscriptMessage getMessages(int index);

    /**
     * <pre>
     * Chat messages.
     * </pre>
     *
     * <code>repeated .com.fissy.dialer.rtt.RttTranscriptMessage messages = 4;</code>
     */
    int getMessagesCount();
}
