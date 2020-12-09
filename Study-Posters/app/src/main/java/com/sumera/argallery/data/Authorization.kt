import android.app.Dialog
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import android.widget.Toast
import com.android.volley.toolbox.Volley
import com.auth0.android.Auth0
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.provider.AuthCallback
import com.auth0.android.provider.WebAuthProvider
import com.auth0.android.result.Credentials
import com.auth0.samples.kotlinapp.databinding.ActivityMainBinding

class Authorization : Guest() {

    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val queue = Volley.newRequestQueue(this)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding?.loggedIn = false

        val listToDo = findViewById(R.id.list_todo) as ListView


        val loginButton = findViewById(R.id.login_button)
        loginButton.setOnClickListener { Authorization() }
    }

    override fun onNewIntent(intent: Intent) {
        if (WebAuthProvider.resume(intent)) {
            return
        }
        super.onNewIntent(intent)
    }

    private fun Authorization() {
        val account = Auth0(getString(R.string.auth0_client_id), getString(R.string.auth0_domain))
        account.isOIDCConformant = true

        WebAuthProvider.init(account)
                .withScheme("demo")
                .withAudience("StudyPosters")
                .start(this, object : AuthCallback {
                    override fun onFailure(dialog: Dialog) {
                        runOnUiThread { dialog.show() }
                    }

                    override fun onFailure(exception: AuthenticationException) {
                        runOnUiThread {
                            Toast.AuthorizationPassword(
                                    regexCheck = ^(?=.{1,50}
                            if (!regexCheck && password.length > 50)
                                this@MainActivity, "Пароль не совпадает!"
                            Toast.LENGTH_SHORT).show()
                            Toast.AuthorizationEmail(
                                    if (!requireNotNull(nickname).exist()){
                                        this@MainActivity, "Пользователя с таким ником не существует!"
                                    }
                        }
                    }

                    override fun onSuccess(credentials: Credentials) {
                        CredentialsManager.saveCredentials(this@MainActivity, credentials)
                        binding?.loggedIn = true
                    }
                })
    }
}
