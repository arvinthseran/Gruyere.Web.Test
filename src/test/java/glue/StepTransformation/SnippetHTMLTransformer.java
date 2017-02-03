package glue.StepTransformation;

import cucumber.api.Transformer;

/**
 * Created by arvinth seran on 02/02/2017.
 */
public class SnippetHTMLTransformer extends Transformer<String> {

    @Override
    public String transform(String text) {
            return String.format("<b>%1$s</b><br><small>%1$s</small><br><i>%1$s</i>",text);
    }
}
