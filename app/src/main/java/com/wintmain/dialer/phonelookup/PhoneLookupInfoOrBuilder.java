// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: packages/apps/Dialer/java/com/fissy/dialer/phonelookup/phone_lookup_info.proto

package com.wintmain.dialer.phonelookup;

public interface PhoneLookupInfoOrBuilder extends
        // @@protoc_insertion_point(interface_extends:com.wintmain.dialer.phonelookup.PhoneLookupInfo)
        com.google.protobuf.MessageLiteOrBuilder {

    /**
     * <pre>
     * Information about a contact in the default directory, retrieved via CP2.
     * Cp2DefaultDirectoryPhoneLookup is responsible for populating this field.
     * </pre>
     *
     * <code>optional .com.wintmain.dialer.phonelookup.PhoneLookupInfo.Cp2Info default_cp2_info = 1;</code>
     */
    boolean hasDefaultCp2Info();

    /**
     * <pre>
     * Information about a contact in the default directory, retrieved via CP2.
     * Cp2DefaultDirectoryPhoneLookup is responsible for populating this field.
     * </pre>
     *
     * <code>optional .com.wintmain.dialer.phonelookup.PhoneLookupInfo.Cp2Info default_cp2_info = 1;</code>
     */
    com.wintmain.dialer.phonelookup.PhoneLookupInfo.Cp2Info getDefaultCp2Info();

    /**
     * <pre>
     * Information about a contact in other directories, retrieved via CP2.
     * Cp2ExtendedDirectoryPhoneLookup is responsible for populating this field.
     * </pre>
     *
     * <code>optional .com.wintmain.dialer.phonelookup.PhoneLookupInfo.Cp2Info extended_cp2_info = 6;</code>
     */
    boolean hasExtendedCp2Info();

    /**
     * <pre>
     * Information about a contact in other directories, retrieved via CP2.
     * Cp2ExtendedDirectoryPhoneLookup is responsible for populating this field.
     * </pre>
     *
     * <code>optional .com.wintmain.dialer.phonelookup.PhoneLookupInfo.Cp2Info extended_cp2_info = 6;</code>
     */
    com.wintmain.dialer.phonelookup.PhoneLookupInfo.Cp2Info getExtendedCp2Info();

    /**
     * <code>optional .com.wintmain.dialer.phonelookup.PhoneLookupInfo.SpamInfo spam_info = 2;</code>
     */
    boolean hasSpamInfo();

    /**
     * <code>optional .com.wintmain.dialer.phonelookup.PhoneLookupInfo.SpamInfo spam_info = 2;</code>
     */
    com.wintmain.dialer.phonelookup.PhoneLookupInfo.SpamInfo getSpamInfo();

    /**
     * <code>optional .com.wintmain.dialer.phonelookup.PhoneLookupInfo.PeopleApiInfo people_api_info = 3;</code>
     */
    boolean hasPeopleApiInfo();

    /**
     * <code>optional .com.wintmain.dialer.phonelookup.PhoneLookupInfo.PeopleApiInfo people_api_info = 3;</code>
     */
    com.wintmain.dialer.phonelookup.PhoneLookupInfo.PeopleApiInfo getPeopleApiInfo();

    /**
     * <code>optional .com.wintmain.dialer.phonelookup.PhoneLookupInfo.SystemBlockedNumberInfo system_blocked_number_info = 4;</code>
     */
    boolean hasSystemBlockedNumberInfo();

    /**
     * <code>optional .com.wintmain.dialer.phonelookup.PhoneLookupInfo.SystemBlockedNumberInfo system_blocked_number_info = 4;</code>
     */
    com.wintmain.dialer.phonelookup.PhoneLookupInfo.SystemBlockedNumberInfo getSystemBlockedNumberInfo();

    /**
     * <code>optional .com.wintmain.dialer.phonelookup.PhoneLookupInfo.CnapInfo cnap_info = 7;</code>
     */
    boolean hasCnapInfo();

    /**
     * <code>optional .com.wintmain.dialer.phonelookup.PhoneLookupInfo.CnapInfo cnap_info = 7;</code>
     */
    com.wintmain.dialer.phonelookup.PhoneLookupInfo.CnapInfo getCnapInfo();

    /**
     * <code>optional .com.wintmain.dialer.phonelookup.PhoneLookupInfo.CequintInfo cequint_info = 8;</code>
     */
    boolean hasCequintInfo();

    /**
     * <code>optional .com.wintmain.dialer.phonelookup.PhoneLookupInfo.CequintInfo cequint_info = 8;</code>
     */
    com.wintmain.dialer.phonelookup.PhoneLookupInfo.CequintInfo getCequintInfo();

    /**
     * <code>optional .com.wintmain.dialer.phonelookup.PhoneLookupInfo.EmergencyInfo emergency_info = 9;</code>
     */
    boolean hasEmergencyInfo();

    /**
     * <code>optional .com.wintmain.dialer.phonelookup.PhoneLookupInfo.EmergencyInfo emergency_info = 9;</code>
     */
    com.wintmain.dialer.phonelookup.PhoneLookupInfo.EmergencyInfo getEmergencyInfo();

    /**
     * <code>optional .com.wintmain.dialer.phonelookup.PhoneLookupInfo.MigratedInfo migrated_info = 10;</code>
     */
    boolean hasMigratedInfo();

    /**
     * <code>optional .com.wintmain.dialer.phonelookup.PhoneLookupInfo.MigratedInfo migrated_info = 10;</code>
     */
    com.wintmain.dialer.phonelookup.PhoneLookupInfo.MigratedInfo getMigratedInfo();
}
