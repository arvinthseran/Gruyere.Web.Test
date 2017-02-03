package glue.StepTransformation;

import cucumber.api.Transformer;

import java.time.LocalDateTime;

/**
 * Created by arvinth seran on 02/02/2017.
 */
public class UserNameTransformer extends Transformer<String> {

    @Override
    public String transform(String text) {

        return String.format("%s%s%s%s%s%s"
                , text,
                LocalDateTime.now().getDayOfMonth(),
                LocalDateTime.now().getMonthValue(),
                LocalDateTime.now().getYear(),
                LocalDateTime.now().getHour(),
                LocalDateTime.now().getMinute());
    }
}
