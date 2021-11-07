package org.mikunonaka.animegirldialer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class Numpad extends Fragment implements View.OnClickListener, View.OnLongClickListener {
    EditText phoneInput;

    public Numpad() {
        super(R.layout.fragment_numpad);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_numpad, container, false);

        // suppress soft keyboard
        phoneInput = view.findViewById(R.id.phone_input);
        phoneInput.setShowSoftInputOnFocus(false);

        Button[] num_buttons = {
                view.findViewById(R.id.num_0),
                view.findViewById(R.id.num_1),
                view.findViewById(R.id.num_2),
                view.findViewById(R.id.num_3),
                view.findViewById(R.id.num_4),
                view.findViewById(R.id.num_5),
                view.findViewById(R.id.num_6),
                view.findViewById(R.id.num_7),
                view.findViewById(R.id.num_8),
                view.findViewById(R.id.num_9),
                view.findViewById(R.id.num_star),
                view.findViewById(R.id.num_hashtag),
        };

        for (Button btn : num_buttons) {
            btn.setOnClickListener(this);
        }

        view.findViewById(R.id.num_0).setOnLongClickListener(this);

        return view;
    }

    void updateInputText(String currentInput, String newChar, int index) {
        phoneInput.setText(currentInput.substring(0, index) + newChar + currentInput.substring(index));
    }

    @Override
    public boolean onLongClick(View view) {
        if (view.getId() == R.id.num_0) {
            int selectionEnd = phoneInput.getSelectionEnd();
            updateInputText(phoneInput.getText().toString(), "+", selectionEnd);
            phoneInput.setSelection(selectionEnd + 1);
        }
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        String currentInput = phoneInput.getText().toString();
        int selectionEnd = phoneInput.getSelectionEnd();

        switch (view.getId()) {
            case R.id.num_0:
                updateInputText(currentInput, "0", selectionEnd);
                break;
            case R.id.num_1:
                updateInputText(currentInput, "1", selectionEnd);
                break;
            case R.id.num_2:
                updateInputText(currentInput, "2", selectionEnd);
                break;
            case R.id.num_3:
                updateInputText(currentInput, "3", selectionEnd);
                break;
            case R.id.num_4:
                updateInputText(currentInput, "4", selectionEnd);
                break;
            case R.id.num_5:
                updateInputText(currentInput, "5", selectionEnd);
                break;
            case R.id.num_6:
                updateInputText(currentInput, "6", selectionEnd);
                break;
            case R.id.num_7:
                updateInputText(currentInput, "7", selectionEnd);
                break;
            case R.id.num_8:
                updateInputText(currentInput, "8", selectionEnd);
                break;
            case R.id.num_9:
                updateInputText(currentInput, "9", selectionEnd);
                break;
            case R.id.num_star:
                updateInputText(currentInput, "*", selectionEnd);
                break;
            case R.id.num_hashtag:
                updateInputText(currentInput, "#", selectionEnd);
                break;
            default:
                break;
        }
        phoneInput.setSelection(selectionEnd + 1);
    }
}