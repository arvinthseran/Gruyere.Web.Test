package glue.StepTransformation;

import cucumber.api.Transformer;

import java.time.LocalDateTime;

/**
 * Created by arvin on 02/02/2017.
 */
public class SnippetTransformer extends Transformer<String> {

    @Override
    public String transform(String text) {
        String format = String.format("Day:%s Month:%s Year:%s Hour:%s Minute:%s Second:%s",
                LocalDateTime.now().getDayOfMonth(),
                LocalDateTime.now().getMonthValue(),
                LocalDateTime.now().getYear(),
                LocalDateTime.now().getHour(),
                LocalDateTime.now().getMinute(),
                LocalDateTime.now().getSecond());
        return text.concat(format);
    }
}
