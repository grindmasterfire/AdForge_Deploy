# Kit750: Firebase + Kotlin safe keep rules

# Keep Firebase classes
-keep class com.google.firebase.** { *; }
-dontwarn com.google.firebase.**

# Keep Kotlin serialization classes
-keep class kotlinx.serialization.** { *; }
-dontwarn kotlinx.serialization.**

# Keep Gson model classes (optional)
-keep class com.adforge.** { *; }

# Keep ViewBinding
-keep class **.databinding.* { *; }
-keepclassmembers class **.databinding.* { *; }

# Avoid warnings for synthetic access
-dontwarn kotlin.jvm.internal.**

# Avoid removing R class
-keep class **.R$* { *; }
