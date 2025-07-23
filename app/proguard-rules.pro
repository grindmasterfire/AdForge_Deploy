# Default ProGuard rules for AdForge
# Preserve Application and MainActivity to prevent stripping
-keep public class * extends android.app.Application
-keep class com.adforge.** { *; }

# Keep Firebase-related classes if added later
-keep class com.google.firebase.** { *; }
-dontwarn com.google.firebase.**

# Enable optimizations safely
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
