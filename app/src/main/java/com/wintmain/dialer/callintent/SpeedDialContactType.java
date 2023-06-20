// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: packages/apps/Dialer/java/com/fissy/dialer/callintent/speed_dial_contact_type.proto

package com.wintmain.dialer.callintent;

/**
 * <pre>
 * The type of speed call contact (favorites). Applies to initiation type
 * SPEED_DIAL only.
 * </pre>
 * <p>
 * Protobuf type {@code com.fissy.dialer.callintent.SpeedDialContactType}
 */
public final class SpeedDialContactType extends
        com.google.protobuf.GeneratedMessageLite<
                SpeedDialContactType, SpeedDialContactType.Builder> implements
        // @@protoc_insertion_point(message_implements:com.fissy.dialer.callintent.SpeedDialContactType)
        SpeedDialContactTypeOrBuilder {
    // @@protoc_insertion_point(class_scope:com.fissy.dialer.callintent.SpeedDialContactType)
    private static final com.wintmain.dialer.callintent.SpeedDialContactType DEFAULT_INSTANCE;
    private static volatile com.google.protobuf.Parser<SpeedDialContactType> PARSER;

    static {
        DEFAULT_INSTANCE = new SpeedDialContactType();
        DEFAULT_INSTANCE.makeImmutable();
    }

    private SpeedDialContactType() {
    }

    public static com.wintmain.dialer.callintent.SpeedDialContactType parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, data);
    }

    public static com.wintmain.dialer.callintent.SpeedDialContactType parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static com.wintmain.dialer.callintent.SpeedDialContactType parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, data);
    }

    public static com.wintmain.dialer.callintent.SpeedDialContactType parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static com.wintmain.dialer.callintent.SpeedDialContactType parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, input);
    }

    public static com.wintmain.dialer.callintent.SpeedDialContactType parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static com.wintmain.dialer.callintent.SpeedDialContactType parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static com.wintmain.dialer.callintent.SpeedDialContactType parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static com.wintmain.dialer.callintent.SpeedDialContactType parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, input);
    }

    public static com.wintmain.dialer.callintent.SpeedDialContactType parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(com.wintmain.dialer.callintent.SpeedDialContactType prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    public static com.wintmain.dialer.callintent.SpeedDialContactType getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<SpeedDialContactType> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
        unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
        int size = memoizedSerializedSize;
        if (size != -1) return size;

        size = 0;
        size += unknownFields.getSerializedSize();
        memoizedSerializedSize = size;
        return size;
    }

    protected Object dynamicMethod(
            com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
            Object arg0, Object arg1) {
        switch (method) {
            case NEW_MUTABLE_INSTANCE: {
                return new com.wintmain.dialer.callintent.SpeedDialContactType();
            }
            case IS_INITIALIZED: {
                return DEFAULT_INSTANCE;
            }
            case MAKE_IMMUTABLE: {
                return null;
            }
            case NEW_BUILDER: {
                return new Builder();
            }
            case VISIT: {
                Visitor visitor = (Visitor) arg0;
                com.wintmain.dialer.callintent.SpeedDialContactType other = (com.wintmain.dialer.callintent.SpeedDialContactType) arg1;
                return this;
            }
            case MERGE_FROM_STREAM: {
                com.google.protobuf.CodedInputStream input =
                        (com.google.protobuf.CodedInputStream) arg0;
                com.google.protobuf.ExtensionRegistryLite extensionRegistry =
                        (com.google.protobuf.ExtensionRegistryLite) arg1;
                try {
                    boolean done = false;
                    while (!done) {
                        int tag = input.readTag();
                        if (tag == 0) {
                            done = true;
                        } else {
                            if (!parseUnknownField(tag, input)) {
                                done = true;
                            }
                        }
                    }
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    throw new RuntimeException(e.setUnfinishedMessage(this));
                } catch (java.io.IOException e) {
                    throw new RuntimeException(
                            new com.google.protobuf.InvalidProtocolBufferException(
                                    e.getMessage()).setUnfinishedMessage(this));
                }
            }
            case GET_DEFAULT_INSTANCE: {
                return DEFAULT_INSTANCE;
            }
            case GET_PARSER: {
                if (PARSER == null) {
                    synchronized (com.wintmain.dialer.callintent.SpeedDialContactType.class) {
                        if (PARSER == null) {
                            PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        }
                    }
                }
                return PARSER;
            }
        }
        throw new UnsupportedOperationException();
    }

    /**
     * Protobuf enum {@code com.fissy.dialer.callintent.SpeedDialContactType.Type}
     */
    public enum Type
            implements com.google.protobuf.Internal.EnumLite {
        /**
         * <code>UNDEFINED = 0;</code>
         */
        UNDEFINED(0),
        /**
         * <code>PINNED_CONTACT = 1;</code>
         */
        PINNED_CONTACT(1),
        /**
         * <code>STARRED_CONTACT = 2;</code>
         */
        STARRED_CONTACT(2),
        /**
         * <code>FREQUENT_CONTACT = 3;</code>
         */
        FREQUENT_CONTACT(3),
        ;

        /**
         * <code>UNDEFINED = 0;</code>
         */
        public static final int UNDEFINED_VALUE = 0;
        /**
         * <code>PINNED_CONTACT = 1;</code>
         */
        public static final int PINNED_CONTACT_VALUE = 1;
        /**
         * <code>STARRED_CONTACT = 2;</code>
         */
        public static final int STARRED_CONTACT_VALUE = 2;
        /**
         * <code>FREQUENT_CONTACT = 3;</code>
         */
        public static final int FREQUENT_CONTACT_VALUE = 3;
        private static final com.google.protobuf.Internal.EnumLiteMap<
                Type> internalValueMap =
                number -> Type.forNumber(number);
        private final int value;

        Type(int value) {
            this.value = value;
        }

        /**
         * @deprecated Use {@link #forNumber(int)} instead.
         */
        @java.lang.Deprecated
        public static Type valueOf(int value) {
            return forNumber(value);
        }

        public static Type forNumber(int value) {
            switch (value) {
                case 0:
                    return UNDEFINED;
                case 1:
                    return PINNED_CONTACT;
                case 2:
                    return STARRED_CONTACT;
                case 3:
                    return FREQUENT_CONTACT;
                default:
                    return null;
            }
        }

        public static com.google.protobuf.Internal.EnumLiteMap<Type>
        internalGetValueMap() {
            return internalValueMap;
        }

        public final int getNumber() {
            return value;
        }

        // @@protoc_insertion_point(enum_scope:com.fissy.dialer.callintent.SpeedDialContactType.Type)
    }

    /**
     * <pre>
     * The type of speed call contact (favorites). Applies to initiation type
     * SPEED_DIAL only.
     * </pre>
     * <p>
     * Protobuf type {@code com.fissy.dialer.callintent.SpeedDialContactType}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageLite.Builder<
                    com.wintmain.dialer.callintent.SpeedDialContactType, Builder> implements
            // @@protoc_insertion_point(builder_implements:com.fissy.dialer.callintent.SpeedDialContactType)
            com.wintmain.dialer.callintent.SpeedDialContactTypeOrBuilder {
        // Construct using com.fissy.dialer.callintent.SpeedDialContactType.newBuilder()
        private Builder() {
            super(DEFAULT_INSTANCE);
        }


        // @@protoc_insertion_point(builder_scope:com.fissy.dialer.callintent.SpeedDialContactType)
    }
}

