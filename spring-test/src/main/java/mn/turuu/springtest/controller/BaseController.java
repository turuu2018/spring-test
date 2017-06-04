package mn.turuu.springtest.controller;

import mn.turuu.springtest.form.SearchForm;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author PDBD
 */
@ControllerAdvice
public class BaseController {

    @ModelAttribute
    public SearchForm initSearchForm() {
        return new SearchForm();
    }

    public void init(ModelAndView mav) {
        mav.addObject("searchForm", new SearchForm());
    }
}
