import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration : Guest() {

    EditText firstLastName;
    EditText email;
    EditText password;
    EditText confirmPassword;
    EditText phone;
    EditText nickname;
    Button register;
    Button cancel;
    val fields = listOf(EditText);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstLastName = findViewById(R.id.firstLastName);
        nickname = findViewById(R.id.address);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        phoneNumber = findViewById(R.id.phoneNumber);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
            }
        });
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered() {
        if (firstName > 80) {
            Toast t = Toast.makeText(this, "ФИО слишком длинное!", Toast.LENGTH_SHORT);
            t.show();
        }

        if (nickname.exist()) {
            nickname.setError("Пользователь с таким никнеймом уже существует!");
        }

        if (requireNotNull(fields).forEach{it.keys}) {
            fields.setError("Одно или несколько полей не заполнено!");
        }
        if (!confirmPassword.equals(password)) {
            fields.setError("Пароли не совпадают!");
        }

    }
}
