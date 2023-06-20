// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: packages/apps/Dialer/java/com/fissy/dialer/logging/contact_lookup_result.proto

package com.wintmain.dialer.logging;

/**
 * Protobuf type {@code com.fissy.dialer.logging.ContactLookupResult}
 */
public final class ContactLookupResult extends
        com.google.protobuf.GeneratedMessageLite<
                ContactLookupResult, ContactLookupResult.Builder> implements
        // @@protoc_insertion_point(message_implements:com.fissy.dialer.logging.ContactLookupResult)
        ContactLookupResultOrBuilder {
    // @@protoc_insertion_point(class_scope:com.fissy.dialer.logging.ContactLookupResult)
    private static final com.wintmain.dialer.logging.ContactLookupResult DEFAULT_INSTANCE;
    private static volatile com.google.protobuf.Parser<ContactLookupResult> PARSER;

    static {
        DEFAULT_INSTANCE = new ContactLookupResult();
        DEFAULT_INSTANCE.makeImmutable();
    }

    private ContactLookupResult() {
    }

    public static com.wintmain.dialer.logging.ContactLookupResult parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, data);
    }

    public static com.wintmain.dialer.logging.ContactLookupResult parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static com.wintmain.dialer.logging.ContactLookupResult parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, data);
    }

    public static com.wintmain.dialer.logging.ContactLookupResult parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static com.wintmain.dialer.logging.ContactLookupResult parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, input);
    }

    public static com.wintmain.dialer.logging.ContactLookupResult parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static com.wintmain.dialer.logging.ContactLookupResult parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static com.wintmain.dialer.logging.ContactLookupResult parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static com.wintmain.dialer.logging.ContactLookupResult parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, input);
    }

    public static com.wintmain.dialer.logging.ContactLookupResult parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(com.wintmain.dialer.logging.ContactLookupResult prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    public static com.wintmain.dialer.logging.ContactLookupResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<ContactLookupResult> parser() {
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
                return new com.wintmain.dialer.logging.ContactLookupResult();
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
                com.wintmain.dialer.logging.ContactLookupResult other = (com.wintmain.dialer.logging.ContactLookupResult) arg1;
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
                    synchronized (com.wintmain.dialer.logging.ContactLookupResult.class) {
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
     * <pre>
     * The different results of a contact lookup done using a phone number.
     * </pre>
     * <p>
     * Protobuf enum {@code com.fissy.dialer.logging.ContactLookupResult.Type}
     */
    public enum Type
            implements com.google.protobuf.Internal.EnumLite {
        /**
         * <code>UNKNOWN_LOOKUP_RESULT_TYPE = 0;</code>
         */
        UNKNOWN_LOOKUP_RESULT_TYPE(0),
        /**
         * <pre>
         * Contact was not found in any of the sources.
         * </pre>
         *
         * <code>NOT_FOUND = 1;</code>
         */
        NOT_FOUND(1),
        /**
         * <pre>
         * Contact was found in the local database.
         * </pre>
         *
         * <code>LOCAL_CONTACT = 2;</code>
         */
        LOCAL_CONTACT(2),
        /**
         * <pre>
         * DEPRECATED: see subcategories below
         * </pre>
         *
         * <code>LOCAL_CACHE = 3;</code>
         */
        LOCAL_CACHE(3),
        /**
         * <pre>
         * DEPRECATED: see subcategories below
         * </pre>
         *
         * <code>REMOTE = 4;</code>
         */
        REMOTE(4),
        /**
         * <pre>
         * Phone number was an emergency phone number
         * </pre>
         *
         * <code>EMERGENCY = 5;</code>
         */
        EMERGENCY(5),
        /**
         * <pre>
         * Phone number was the SIM card's voicemail number
         * </pre>
         *
         * <code>VOICEMAIL = 6;</code>
         */
        VOICEMAIL(6),
        /**
         * <pre>
         * Phone number was identified via the places part of the People API.
         * </pre>
         *
         * <code>REMOTE_PLACES = 7;</code>
         */
        REMOTE_PLACES(7),
        /**
         * <pre>
         * Phone number was identified via the profile part of the People API.
         * </pre>
         *
         * <code>REMOTE_PROFILE = 8;</code>
         */
        REMOTE_PROFILE(8),
        /**
         * <pre>
         * Number was found in Dialer's local cache but we don't know how it was
         * originally identified.
         * </pre>
         *
         * <code>LOCAL_CACHE_UNKNOWN = 9;</code>
         */
        LOCAL_CACHE_UNKNOWN(9),
        /**
         * <pre>
         * Number was found in Dialer's local cache and was originally identified
         * as a personal contact.
         * </pre>
         *
         * <code>LOCAL_CACHE_DIRECTORY = 10;</code>
         */
        LOCAL_CACHE_DIRECTORY(10),
        /**
         * <pre>
         * Number was found in Dialer's local cache and was originally identified
         * via a custom extended directory.
         * </pre>
         *
         * <code>LOCAL_CACHE_EXTENDED = 11;</code>
         */
        LOCAL_CACHE_EXTENDED(11),
        /**
         * <pre>
         * Number was found in Dialer's local cache and was originally identified
         * via the places part of the People API.
         * </pre>
         *
         * <code>LOCAL_CACHE_PLACES = 12;</code>
         */
        LOCAL_CACHE_PLACES(12),
        /**
         * <pre>
         * Number was found in Dialer's local cache and was originally identified
         * via the profile part of the People API.
         * </pre>
         *
         * <code>LOCAL_CACHE_PROFILE = 13;</code>
         */
        LOCAL_CACHE_PROFILE(13),
        /**
         * <pre>
         * Number was found in Dialer's local cache and was originally identified
         * via Caller Name Presentation (CNAP) information. Calls in this
         * category would have had ContactLookupResultType NOT_FOUND originally.
         * </pre>
         *
         * <code>LOCAL_CACHE_CNAP = 14;</code>
         */
        LOCAL_CACHE_CNAP(14),
        /**
         * <pre>
         * Number was found in Dialer's local cache and was originally identified
         * via Cequint caller ID.
         * </pre>
         *
         * <code>LOCAL_CACHE_CEQUINT = 15;</code>
         */
        LOCAL_CACHE_CEQUINT(15),
        /**
         * <pre>
         * Number was identified by a remote data source not listed below
         * </pre>
         *
         * <code>REMOTE_OTHER = 16;</code>
         */
        REMOTE_OTHER(16),
        /**
         * <pre>
         * Number was found in Dialer's local cache and was originally identified
         * as REMOTE_OTHER
         * </pre>
         *
         * <code>LOCAL_CACHE_REMOTE_OTHER = 17;</code>
         */
        LOCAL_CACHE_REMOTE_OTHER(17),
        /**
         * <pre>
         * Number was identified by manually-entered caller ID data
         * </pre>
         *
         * <code>REMOTE_MANUAL = 18;</code>
         */
        REMOTE_MANUAL(18),
        /**
         * <pre>
         * Number was found in Dialer's local cache and was originally identified
         * as REMOTE_MANUAL
         * </pre>
         *
         * <code>LOCAL_CACHE_REMOTE_MANUAL = 19;</code>
         */
        LOCAL_CACHE_REMOTE_MANUAL(19),
        /**
         * <pre>
         * Number was identified by Google Voice data
         * </pre>
         *
         * <code>REMOTE_GOOGLE_VOICE = 20;</code>
         */
        REMOTE_GOOGLE_VOICE(20),
        /**
         * <pre>
         * Number was found in Dialer's local cache and was originally identified
         * as REMOTE_GOOGLE_VOICE
         * </pre>
         *
         * <code>LOCAL_CACHE_REMOTE_GOOGLE_VOICE = 21;</code>
         */
        LOCAL_CACHE_REMOTE_GOOGLE_VOICE(21),
        /**
         * <pre>
         * Number was identified by Customer Service Apps data
         * </pre>
         *
         * <code>REMOTE_CSA = 22;</code>
         */
        REMOTE_CSA(22),
        /**
         * <pre>
         * Number was found in Dialer's local cache and was originally identified
         * as REMOTE_CSA
         * </pre>
         *
         * <code>LOCAL_CACHE_REMOTE_CSA = 23;</code>
         */
        LOCAL_CACHE_REMOTE_CSA(23),
        /**
         * <pre>
         * Number was identified by Knowledge Graph data
         * </pre>
         *
         * <code>REMOTE_KNOWLEDGE_GRAPH = 24;</code>
         */
        REMOTE_KNOWLEDGE_GRAPH(24),
        /**
         * <pre>
         * Number was found in Dialer's local cache and was originally identified
         * as REMOTE_KNOWLEDGE_GRAPH
         * </pre>
         *
         * <code>LOCAL_CACHE_REMOTE_KNOWLEDGE_GRAPH = 25;</code>
         */
        LOCAL_CACHE_REMOTE_KNOWLEDGE_GRAPH(25),
        /**
         * <pre>
         * Number was identified via Cequint caller ID.
         * </pre>
         *
         * <code>CEQUINT = 26;</code>
         */
        CEQUINT(26),
        ;

        /**
         * <code>UNKNOWN_LOOKUP_RESULT_TYPE = 0;</code>
         */
        public static final int UNKNOWN_LOOKUP_RESULT_TYPE_VALUE = 0;
        /**
         * <pre>
         * Contact was not found in any of the sources.
         * </pre>
         *
         * <code>NOT_FOUND = 1;</code>
         */
        public static final int NOT_FOUND_VALUE = 1;
        /**
         * <pre>
         * Contact was found in the local database.
         * </pre>
         *
         * <code>LOCAL_CONTACT = 2;</code>
         */
        public static final int LOCAL_CONTACT_VALUE = 2;
        /**
         * <pre>
         * DEPRECATED: see subcategories below
         * </pre>
         *
         * <code>LOCAL_CACHE = 3;</code>
         */
        public static final int LOCAL_CACHE_VALUE = 3;
        /**
         * <pre>
         * DEPRECATED: see subcategories below
         * </pre>
         *
         * <code>REMOTE = 4;</code>
         */
        public static final int REMOTE_VALUE = 4;
        /**
         * <pre>
         * Phone number was an emergency phone number
         * </pre>
         *
         * <code>EMERGENCY = 5;</code>
         */
        public static final int EMERGENCY_VALUE = 5;
        /**
         * <pre>
         * Phone number was the SIM card's voicemail number
         * </pre>
         *
         * <code>VOICEMAIL = 6;</code>
         */
        public static final int VOICEMAIL_VALUE = 6;
        /**
         * <pre>
         * Phone number was identified via the places part of the People API.
         * </pre>
         *
         * <code>REMOTE_PLACES = 7;</code>
         */
        public static final int REMOTE_PLACES_VALUE = 7;
        /**
         * <pre>
         * Phone number was identified via the profile part of the People API.
         * </pre>
         *
         * <code>REMOTE_PROFILE = 8;</code>
         */
        public static final int REMOTE_PROFILE_VALUE = 8;
        /**
         * <pre>
         * Number was found in Dialer's local cache but we don't know how it was
         * originally identified.
         * </pre>
         *
         * <code>LOCAL_CACHE_UNKNOWN = 9;</code>
         */
        public static final int LOCAL_CACHE_UNKNOWN_VALUE = 9;
        /**
         * <pre>
         * Number was found in Dialer's local cache and was originally identified
         * as a personal contact.
         * </pre>
         *
         * <code>LOCAL_CACHE_DIRECTORY = 10;</code>
         */
        public static final int LOCAL_CACHE_DIRECTORY_VALUE = 10;
        /**
         * <pre>
         * Number was found in Dialer's local cache and was originally identified
         * via a custom extended directory.
         * </pre>
         *
         * <code>LOCAL_CACHE_EXTENDED = 11;</code>
         */
        public static final int LOCAL_CACHE_EXTENDED_VALUE = 11;
        /**
         * <pre>
         * Number was found in Dialer's local cache and was originally identified
         * via the places part of the People API.
         * </pre>
         *
         * <code>LOCAL_CACHE_PLACES = 12;</code>
         */
        public static final int LOCAL_CACHE_PLACES_VALUE = 12;
        /**
         * <pre>
         * Number was found in Dialer's local cache and was originally identified
         * via the profile part of the People API.
         * </pre>
         *
         * <code>LOCAL_CACHE_PROFILE = 13;</code>
         */
        public static final int LOCAL_CACHE_PROFILE_VALUE = 13;
        /**
         * <pre>
         * Number was found in Dialer's local cache and was originally identified
         * via Caller Name Presentation (CNAP) information. Calls in this
         * category would have had ContactLookupResultType NOT_FOUND originally.
         * </pre>
         *
         * <code>LOCAL_CACHE_CNAP = 14;</code>
         */
        public static final int LOCAL_CACHE_CNAP_VALUE = 14;
        /**
         * <pre>
         * Number was found in Dialer's local cache and was originally identified
         * via Cequint caller ID.
         * </pre>
         *
         * <code>LOCAL_CACHE_CEQUINT = 15;</code>
         */
        public static final int LOCAL_CACHE_CEQUINT_VALUE = 15;
        /**
         * <pre>
         * Number was identified by a remote data source not listed below
         * </pre>
         *
         * <code>REMOTE_OTHER = 16;</code>
         */
        public static final int REMOTE_OTHER_VALUE = 16;
        /**
         * <pre>
         * Number was found in Dialer's local cache and was originally identified
         * as REMOTE_OTHER
         * </pre>
         *
         * <code>LOCAL_CACHE_REMOTE_OTHER = 17;</code>
         */
        public static final int LOCAL_CACHE_REMOTE_OTHER_VALUE = 17;
        /**
         * <pre>
         * Number was identified by manually-entered caller ID data
         * </pre>
         *
         * <code>REMOTE_MANUAL = 18;</code>
         */
        public static final int REMOTE_MANUAL_VALUE = 18;
        /**
         * <pre>
         * Number was found in Dialer's local cache and was originally identified
         * as REMOTE_MANUAL
         * </pre>
         *
         * <code>LOCAL_CACHE_REMOTE_MANUAL = 19;</code>
         */
        public static final int LOCAL_CACHE_REMOTE_MANUAL_VALUE = 19;
        /**
         * <pre>
         * Number was identified by Google Voice data
         * </pre>
         *
         * <code>REMOTE_GOOGLE_VOICE = 20;</code>
         */
        public static final int REMOTE_GOOGLE_VOICE_VALUE = 20;
        /**
         * <pre>
         * Number was found in Dialer's local cache and was originally identified
         * as REMOTE_GOOGLE_VOICE
         * </pre>
         *
         * <code>LOCAL_CACHE_REMOTE_GOOGLE_VOICE = 21;</code>
         */
        public static final int LOCAL_CACHE_REMOTE_GOOGLE_VOICE_VALUE = 21;
        /**
         * <pre>
         * Number was identified by Customer Service Apps data
         * </pre>
         *
         * <code>REMOTE_CSA = 22;</code>
         */
        public static final int REMOTE_CSA_VALUE = 22;
        /**
         * <pre>
         * Number was found in Dialer's local cache and was originally identified
         * as REMOTE_CSA
         * </pre>
         *
         * <code>LOCAL_CACHE_REMOTE_CSA = 23;</code>
         */
        public static final int LOCAL_CACHE_REMOTE_CSA_VALUE = 23;
        /**
         * <pre>
         * Number was identified by Knowledge Graph data
         * </pre>
         *
         * <code>REMOTE_KNOWLEDGE_GRAPH = 24;</code>
         */
        public static final int REMOTE_KNOWLEDGE_GRAPH_VALUE = 24;
        /**
         * <pre>
         * Number was found in Dialer's local cache and was originally identified
         * as REMOTE_KNOWLEDGE_GRAPH
         * </pre>
         *
         * <code>LOCAL_CACHE_REMOTE_KNOWLEDGE_GRAPH = 25;</code>
         */
        public static final int LOCAL_CACHE_REMOTE_KNOWLEDGE_GRAPH_VALUE = 25;
        /**
         * <pre>
         * Number was identified via Cequint caller ID.
         * </pre>
         *
         * <code>CEQUINT = 26;</code>
         */
        public static final int CEQUINT_VALUE = 26;
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
                    return UNKNOWN_LOOKUP_RESULT_TYPE;
                case 1:
                    return NOT_FOUND;
                case 2:
                    return LOCAL_CONTACT;
                case 3:
                    return LOCAL_CACHE;
                case 4:
                    return REMOTE;
                case 5:
                    return EMERGENCY;
                case 6:
                    return VOICEMAIL;
                case 7:
                    return REMOTE_PLACES;
                case 8:
                    return REMOTE_PROFILE;
                case 9:
                    return LOCAL_CACHE_UNKNOWN;
                case 10:
                    return LOCAL_CACHE_DIRECTORY;
                case 11:
                    return LOCAL_CACHE_EXTENDED;
                case 12:
                    return LOCAL_CACHE_PLACES;
                case 13:
                    return LOCAL_CACHE_PROFILE;
                case 14:
                    return LOCAL_CACHE_CNAP;
                case 15:
                    return LOCAL_CACHE_CEQUINT;
                case 16:
                    return REMOTE_OTHER;
                case 17:
                    return LOCAL_CACHE_REMOTE_OTHER;
                case 18:
                    return REMOTE_MANUAL;
                case 19:
                    return LOCAL_CACHE_REMOTE_MANUAL;
                case 20:
                    return REMOTE_GOOGLE_VOICE;
                case 21:
                    return LOCAL_CACHE_REMOTE_GOOGLE_VOICE;
                case 22:
                    return REMOTE_CSA;
                case 23:
                    return LOCAL_CACHE_REMOTE_CSA;
                case 24:
                    return REMOTE_KNOWLEDGE_GRAPH;
                case 25:
                    return LOCAL_CACHE_REMOTE_KNOWLEDGE_GRAPH;
                case 26:
                    return CEQUINT;
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

        // @@protoc_insertion_point(enum_scope:com.fissy.dialer.logging.ContactLookupResult.Type)
    }

    /**
     * Protobuf type {@code com.fissy.dialer.logging.ContactLookupResult}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageLite.Builder<
                    com.wintmain.dialer.logging.ContactLookupResult, Builder> implements
            // @@protoc_insertion_point(builder_implements:com.fissy.dialer.logging.ContactLookupResult)
            com.wintmain.dialer.logging.ContactLookupResultOrBuilder {
        // Construct using com.fissy.dialer.logging.ContactLookupResult.newBuilder()
        private Builder() {
            super(DEFAULT_INSTANCE);
        }


        // @@protoc_insertion_point(builder_scope:com.fissy.dialer.logging.ContactLookupResult)
    }
}

