import java.text.SimpleDateFormat
import java.util.Locale
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
    // ?? Fallback Retry Button (Firebase session reset)
    if (auth.currentUser == null) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Having trouble signing in?",
                style = MaterialTheme.typography.bodyMedium
            )
            Button(
                onClick = {
                    auth.signOut()
                    navController.navigate("login") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                modifier = Modifier
                    .padding(top = 8.dp)
            ) {
                Text("Retry Login")
            }
        }
    }
// ?? Retry wrapper for login
fun retryFirebaseLogin(email: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit) {
    var retryCount = 0
    val maxRetries = 2

    fun attempt() {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { error ->
                if (++retryCount <= maxRetries) attempt()
                else onError(error.localizedMessage ?: "Unknown error")
            }
    }

    attempt()
}

