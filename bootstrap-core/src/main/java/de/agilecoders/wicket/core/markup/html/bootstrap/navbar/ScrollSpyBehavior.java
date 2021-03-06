package de.agilecoders.wicket.core.markup.html.bootstrap.navbar;

import static de.agilecoders.wicket.jquery.JQuery.$;
import static de.agilecoders.wicket.jquery.function.EachJqueryFunction.each;

import de.agilecoders.wicket.jquery.function.JavaScriptInlineFunction;
import org.apache.wicket.Component;
import org.apache.wicket.core.request.handler.IPartialPageRequestHandler;
import org.apache.wicket.markup.head.IHeaderResponse;

import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.BootstrapBaseBehavior;


/**
 * A {@link ScrollSpyBehavior} updates the active state of a assigned
 * component according to the current scroll position.
 *
 * @author miha
 */
public class ScrollSpyBehavior extends BootstrapBaseBehavior {

    /**
     * updates the ui after new dom elements were added or removed.
     *
     * @param target The current active {@link IPartialPageRequestHandler}
     */
    public static void refresh(final IPartialPageRequestHandler target) {
        target.appendJavaScript($("[data-spy=\"scroll\"]")
                                        .chain(each(new JavaScriptInlineFunction("var $spy = $(this).scrollspy('refresh');"))).get());
    }

    @Override
    public void bind(Component component) {
        super.bind(component);

        component.setOutputMarkupId(true);
    }

    @Override
    public void renderHead(Component component, IHeaderResponse headerResponse) {
        super.renderHead(component, headerResponse);

        headerResponse.render($(component).chain("scrollspy").asDomReadyScript());
    }
}
