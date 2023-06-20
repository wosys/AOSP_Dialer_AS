// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: packages/apps/Dialer/java/com/fissy/dialer/logging/screen_event.proto

package com.wintmain.dialer.logging;

/**
 * Protobuf type {@code com.fissy.dialer.logging.ScreenEvent}
 */
public final class ScreenEvent extends
        com.google.protobuf.GeneratedMessageLite<
                ScreenEvent, ScreenEvent.Builder> implements
        // @@protoc_insertion_point(message_implements:com.fissy.dialer.logging.ScreenEvent)
        ScreenEventOrBuilder {
    // @@protoc_insertion_point(class_scope:com.fissy.dialer.logging.ScreenEvent)
    private static final com.wintmain.dialer.logging.ScreenEvent DEFAULT_INSTANCE;
    private static volatile com.google.protobuf.Parser<ScreenEvent> PARSER;

    static {
        DEFAULT_INSTANCE = new ScreenEvent();
        DEFAULT_INSTANCE.makeImmutable();
    }

    private ScreenEvent() {
    }

    public static com.wintmain.dialer.logging.ScreenEvent parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, data);
    }

    public static com.wintmain.dialer.logging.ScreenEvent parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static com.wintmain.dialer.logging.ScreenEvent parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, data);
    }

    public static com.wintmain.dialer.logging.ScreenEvent parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static com.wintmain.dialer.logging.ScreenEvent parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, input);
    }

    public static com.wintmain.dialer.logging.ScreenEvent parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static com.wintmain.dialer.logging.ScreenEvent parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static com.wintmain.dialer.logging.ScreenEvent parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static com.wintmain.dialer.logging.ScreenEvent parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, input);
    }

    public static com.wintmain.dialer.logging.ScreenEvent parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(com.wintmain.dialer.logging.ScreenEvent prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    public static com.wintmain.dialer.logging.ScreenEvent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<ScreenEvent> parser() {
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
                return new com.wintmain.dialer.logging.ScreenEvent();
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
                com.wintmain.dialer.logging.ScreenEvent other = (com.wintmain.dialer.logging.ScreenEvent) arg1;
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
                    synchronized (com.wintmain.dialer.logging.ScreenEvent.class) {
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
     * Protobuf enum {@code com.fissy.dialer.logging.ScreenEvent.Type}
     */
    public enum Type
            implements com.google.protobuf.Internal.EnumLite {
        /**
         * <code>UNKNOWN = 0;</code>
         */
        UNKNOWN(0),
        /**
         * <code>DIALPAD = 1;</code>
         */
        DIALPAD(1),
        /**
         * <code>SPEED_DIAL = 2;</code>
         */
        SPEED_DIAL(2),
        /**
         * <code>CALL_LOG = 3;</code>
         */
        CALL_LOG(3),
        /**
         * <pre>
         * The tab containing the list of voicemails only.
         * </pre>
         *
         * <code>VOICEMAIL_LOG = 4;</code>
         */
        VOICEMAIL_LOG(4),
        /**
         * <pre>
         * The tab containing the list of all contacts.
         * </pre>
         *
         * <code>ALL_CONTACTS = 5;</code>
         */
        ALL_CONTACTS(5),
        /**
         * <pre>
         * List of search results returned by typing into the search box.
         * </pre>
         *
         * <code>REGULAR_SEARCH = 6;</code>
         */
        REGULAR_SEARCH(6),
        /**
         * <pre>
         * List of search results returned by typing into the dialpad.
         * </pre>
         *
         * <code>SMART_DIAL_SEARCH = 7;</code>
         */
        SMART_DIAL_SEARCH(7),
        /**
         * <code>CALL_LOG_FILTER = 8;</code>
         */
        CALL_LOG_FILTER(8),
        /**
         * <code>SETTINGS = 9;</code>
         */
        SETTINGS(9),
        /**
         * <pre>
         * The "Import/export contacts" dialog launched via the overflow menu.
         * </pre>
         *
         * <code>IMPORT_EXPORT_CONTACTS = 10;</code>
         */
        IMPORT_EXPORT_CONTACTS(10),
        /**
         * <pre>
         * The "Clear frequents" dialog launched via the overflow menu.
         * </pre>
         *
         * <code>CLEAR_FREQUENTS = 11;</code>
         */
        CLEAR_FREQUENTS(11),
        /**
         * <pre>
         * The "Send feedback" dialog launched via the overflow menu.
         * </pre>
         *
         * <code>SEND_FEEDBACK = 12;</code>
         */
        SEND_FEEDBACK(12),
        /**
         * <pre>
         * The main in call screen that displays caller details and contact photos
         * </pre>
         *
         * <code>INCALL = 13;</code>
         */
        INCALL(13),
        /**
         * <pre>
         * The screen that displays the glowpad widget (slide right to answer,
         * slide left to dismiss).
         * </pre>
         *
         * <code>INCOMING_CALL = 14;</code>
         */
        INCOMING_CALL(14),
        /**
         * <pre>
         * Conference management fragment displayed for conferences that support
         * management of individual calls within the conference.
         * </pre>
         *
         * <code>CONFERENCE_MANAGEMENT = 15;</code>
         */
        CONFERENCE_MANAGEMENT(15),
        /**
         * <pre>
         * The dialpad displayed in-call that is used to send dtmf tones.
         * </pre>
         *
         * <code>INCALL_DIALPAD = 16;</code>
         */
        INCALL_DIALPAD(16),
        /**
         * <pre>
         * Menu options displayed when long pressing on a call log entry
         * </pre>
         *
         * <code>CALL_LOG_CONTEXT_MENU = 17;</code>
         */
        CALL_LOG_CONTEXT_MENU(17),
        /**
         * <pre>
         * Screen displayed to allow the user to see an overview of all blocked
         * numbers
         * </pre>
         *
         * <code>BLOCKED_NUMBER_MANAGEMENT = 18;</code>
         */
        BLOCKED_NUMBER_MANAGEMENT(18),
        /**
         * <pre>
         * Screen displayed to allow the user to add a new blocked number
         * </pre>
         *
         * <code>BLOCKED_NUMBER_ADD_NUMBER = 19;</code>
         */
        BLOCKED_NUMBER_ADD_NUMBER(19),
        /**
         * <code>CALL_DETAILS = 20;</code>
         */
        CALL_DETAILS(20),
        /**
         * <code>MAIN_SPEED_DIAL = 21;</code>
         */
        MAIN_SPEED_DIAL(21),
        /**
         * <code>MAIN_CALL_LOG = 22;</code>
         */
        MAIN_CALL_LOG(22),
        /**
         * <code>MAIN_CONTACTS = 23;</code>
         */
        MAIN_CONTACTS(23),
        /**
         * <code>MAIN_VOICEMAIL = 24;</code>
         */
        MAIN_VOICEMAIL(24),
        /**
         * <code>MAIN_DIALPAD = 25;</code>
         */
        MAIN_DIALPAD(25),
        /**
         * <code>MAIN_SEARCH = 26;</code>
         */
        MAIN_SEARCH(26),
        ;

        /**
         * <code>UNKNOWN = 0;</code>
         */
        public static final int UNKNOWN_VALUE = 0;
        /**
         * <code>DIALPAD = 1;</code>
         */
        public static final int DIALPAD_VALUE = 1;
        /**
         * <code>SPEED_DIAL = 2;</code>
         */
        public static final int SPEED_DIAL_VALUE = 2;
        /**
         * <code>CALL_LOG = 3;</code>
         */
        public static final int CALL_LOG_VALUE = 3;
        /**
         * <pre>
         * The tab containing the list of voicemails only.
         * </pre>
         *
         * <code>VOICEMAIL_LOG = 4;</code>
         */
        public static final int VOICEMAIL_LOG_VALUE = 4;
        /**
         * <pre>
         * The tab containing the list of all contacts.
         * </pre>
         *
         * <code>ALL_CONTACTS = 5;</code>
         */
        public static final int ALL_CONTACTS_VALUE = 5;
        /**
         * <pre>
         * List of search results returned by typing into the search box.
         * </pre>
         *
         * <code>REGULAR_SEARCH = 6;</code>
         */
        public static final int REGULAR_SEARCH_VALUE = 6;
        /**
         * <pre>
         * List of search results returned by typing into the dialpad.
         * </pre>
         *
         * <code>SMART_DIAL_SEARCH = 7;</code>
         */
        public static final int SMART_DIAL_SEARCH_VALUE = 7;
        /**
         * <code>CALL_LOG_FILTER = 8;</code>
         */
        public static final int CALL_LOG_FILTER_VALUE = 8;
        /**
         * <code>SETTINGS = 9;</code>
         */
        public static final int SETTINGS_VALUE = 9;
        /**
         * <pre>
         * The "Import/export contacts" dialog launched via the overflow menu.
         * </pre>
         *
         * <code>IMPORT_EXPORT_CONTACTS = 10;</code>
         */
        public static final int IMPORT_EXPORT_CONTACTS_VALUE = 10;
        /**
         * <pre>
         * The "Clear frequents" dialog launched via the overflow menu.
         * </pre>
         *
         * <code>CLEAR_FREQUENTS = 11;</code>
         */
        public static final int CLEAR_FREQUENTS_VALUE = 11;
        /**
         * <pre>
         * The "Send feedback" dialog launched via the overflow menu.
         * </pre>
         *
         * <code>SEND_FEEDBACK = 12;</code>
         */
        public static final int SEND_FEEDBACK_VALUE = 12;
        /**
         * <pre>
         * The main in call screen that displays caller details and contact photos
         * </pre>
         *
         * <code>INCALL = 13;</code>
         */
        public static final int INCALL_VALUE = 13;
        /**
         * <pre>
         * The screen that displays the glowpad widget (slide right to answer,
         * slide left to dismiss).
         * </pre>
         *
         * <code>INCOMING_CALL = 14;</code>
         */
        public static final int INCOMING_CALL_VALUE = 14;
        /**
         * <pre>
         * Conference management fragment displayed for conferences that support
         * management of individual calls within the conference.
         * </pre>
         *
         * <code>CONFERENCE_MANAGEMENT = 15;</code>
         */
        public static final int CONFERENCE_MANAGEMENT_VALUE = 15;
        /**
         * <pre>
         * The dialpad displayed in-call that is used to send dtmf tones.
         * </pre>
         *
         * <code>INCALL_DIALPAD = 16;</code>
         */
        public static final int INCALL_DIALPAD_VALUE = 16;
        /**
         * <pre>
         * Menu options displayed when long pressing on a call log entry
         * </pre>
         *
         * <code>CALL_LOG_CONTEXT_MENU = 17;</code>
         */
        public static final int CALL_LOG_CONTEXT_MENU_VALUE = 17;
        /**
         * <pre>
         * Screen displayed to allow the user to see an overview of all blocked
         * numbers
         * </pre>
         *
         * <code>BLOCKED_NUMBER_MANAGEMENT = 18;</code>
         */
        public static final int BLOCKED_NUMBER_MANAGEMENT_VALUE = 18;
        /**
         * <pre>
         * Screen displayed to allow the user to add a new blocked number
         * </pre>
         *
         * <code>BLOCKED_NUMBER_ADD_NUMBER = 19;</code>
         */
        public static final int BLOCKED_NUMBER_ADD_NUMBER_VALUE = 19;
        /**
         * <code>CALL_DETAILS = 20;</code>
         */
        public static final int CALL_DETAILS_VALUE = 20;
        /**
         * <code>MAIN_SPEED_DIAL = 21;</code>
         */
        public static final int MAIN_SPEED_DIAL_VALUE = 21;
        /**
         * <code>MAIN_CALL_LOG = 22;</code>
         */
        public static final int MAIN_CALL_LOG_VALUE = 22;
        /**
         * <code>MAIN_CONTACTS = 23;</code>
         */
        public static final int MAIN_CONTACTS_VALUE = 23;
        /**
         * <code>MAIN_VOICEMAIL = 24;</code>
         */
        public static final int MAIN_VOICEMAIL_VALUE = 24;
        /**
         * <code>MAIN_DIALPAD = 25;</code>
         */
        public static final int MAIN_DIALPAD_VALUE = 25;
        /**
         * <code>MAIN_SEARCH = 26;</code>
         */
        public static final int MAIN_SEARCH_VALUE = 26;
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
                    return UNKNOWN;
                case 1:
                    return DIALPAD;
                case 2:
                    return SPEED_DIAL;
                case 3:
                    return CALL_LOG;
                case 4:
                    return VOICEMAIL_LOG;
                case 5:
                    return ALL_CONTACTS;
                case 6:
                    return REGULAR_SEARCH;
                case 7:
                    return SMART_DIAL_SEARCH;
                case 8:
                    return CALL_LOG_FILTER;
                case 9:
                    return SETTINGS;
                case 10:
                    return IMPORT_EXPORT_CONTACTS;
                case 11:
                    return CLEAR_FREQUENTS;
                case 12:
                    return SEND_FEEDBACK;
                case 13:
                    return INCALL;
                case 14:
                    return INCOMING_CALL;
                case 15:
                    return CONFERENCE_MANAGEMENT;
                case 16:
                    return INCALL_DIALPAD;
                case 17:
                    return CALL_LOG_CONTEXT_MENU;
                case 18:
                    return BLOCKED_NUMBER_MANAGEMENT;
                case 19:
                    return BLOCKED_NUMBER_ADD_NUMBER;
                case 20:
                    return CALL_DETAILS;
                case 21:
                    return MAIN_SPEED_DIAL;
                case 22:
                    return MAIN_CALL_LOG;
                case 23:
                    return MAIN_CONTACTS;
                case 24:
                    return MAIN_VOICEMAIL;
                case 25:
                    return MAIN_DIALPAD;
                case 26:
                    return MAIN_SEARCH;
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

        // @@protoc_insertion_point(enum_scope:com.fissy.dialer.logging.ScreenEvent.Type)
    }

    /**
     * Protobuf type {@code com.fissy.dialer.logging.ScreenEvent}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageLite.Builder<
                    com.wintmain.dialer.logging.ScreenEvent, Builder> implements
            // @@protoc_insertion_point(builder_implements:com.fissy.dialer.logging.ScreenEvent)
            com.wintmain.dialer.logging.ScreenEventOrBuilder {
        // Construct using com.fissy.dialer.logging.ScreenEvent.newBuilder()
        private Builder() {
            super(DEFAULT_INSTANCE);
        }


        // @@protoc_insertion_point(builder_scope:com.fissy.dialer.logging.ScreenEvent)
    }
}

