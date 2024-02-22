package com.android.libraries.backup;

/**
 * A predicate that determines whether a given key should be backed up.
 */
public interface BackupKeyPredicate {

    /**
     * Returns whether a given key should be backed up.
     */
    boolean shouldBeBackedUp(String key);
}
