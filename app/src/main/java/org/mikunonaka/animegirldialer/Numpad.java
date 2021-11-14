package org.mikunonaka.animegirldialer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Numpad extends Fragment implements View.OnClickListener, View.OnLongClickListener {
    EditText phoneInput;

    public Numpad() {
        super(R.layout.fragment_numpad);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_numpad, container, false);
        phoneInput = view.findViewById(R.id.phone_input);

        // suppress soft keyboard
        phoneInput.setShowSoftInputOnFocus(false);

        Button[] numButtons = {
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

        ImageButton[] imageButtons = {
                view.findViewById(R.id.call_button),
                view.findViewById(R.id.phone_input_backspace)
        };

        for (Button btn : numButtons)
            btn.setOnClickListener(this);

        for (ImageButton btn : imageButtons)
            btn.setOnClickListener(this);

        view.findViewById(R.id.num_0).setOnLongClickListener(this);

        return view;
    }

    @SuppressLint("SetTextI18n")
    void updateInputText(String currentInput, String newChar, int index) {
        phoneInput.setText(currentInput.substring(0, index) + newChar + currentInput.substring(index));
        phoneInput.setSelection(index + 1);
    }

    @Override
    public boolean onLongClick(View view) {
        if (view.getId() == R.id.num_0) {
            int selectionEnd = phoneInput.getSelectionEnd();
            updateInputText(phoneInput.getText().toString(), "+", selectionEnd);
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
            case R.id.phone_input_backspace:
                if (selectionEnd > 0) {
                    String newTxt;
                    newTxt = currentInput.replaceFirst(String.valueOf(currentInput.charAt(selectionEnd - 1)), "");

                    phoneInput.setText(newTxt);

                    if (newTxt.length() > 0) {
                        phoneInput.setSelection(selectionEnd - 1);
                    }
                }
                break;
            case R.id.call_button:
                Toast.makeText(getActivity(), "Calling Coming Soon", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }
}