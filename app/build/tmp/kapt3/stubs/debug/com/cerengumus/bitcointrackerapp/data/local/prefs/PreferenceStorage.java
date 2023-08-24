package com.cerengumus.bitcointrackerapp.data.local.prefs;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00020\bX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/cerengumus/bitcointrackerapp/data/local/prefs/PreferenceStorage;", "", "isDarkMode", "", "()Z", "setDarkMode", "(Z)V", "timeLoadedAt", "", "getTimeLoadedAt", "()J", "setTimeLoadedAt", "(J)V", "app_debug"})
public abstract interface PreferenceStorage {
    
    public abstract long getTimeLoadedAt();
    
    public abstract void setTimeLoadedAt(long p0);
    
    public abstract boolean isDarkMode();
    
    public abstract void setDarkMode(boolean p0);
}