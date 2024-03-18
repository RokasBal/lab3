package Utility;

import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;

public class InputFormatting {
    public static void formatToInt(TextField textField) {
        textField.setTextFormatter(new TextFormatter<>(new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {
                if (change.isContentChange()) {

                    if (change.getControlNewText().matches("([0-9]*)?")) {
                        return change;
                    }
                    return null;
                }
                return change;
            }
        }));
    }
}
