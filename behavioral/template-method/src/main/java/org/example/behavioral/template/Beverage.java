package org.example.behavioral.template;

import java.util.List;

/** Fixes the beverage preparation sequence while subclasses implement its steps. */
public abstract class Beverage {
    public final List<String> prepare() {
        return List.of("boil water", brew(), "pour into cup", condiment());
    }

    protected abstract String brew();

    protected abstract String condiment();

    public static final class Coffee extends Beverage {
        @Override
        protected String brew() {
            return "brew coffee grounds";
        }

        @Override
        protected String condiment() {
            return "add sugar and milk";
        }
    }

    public static final class Tea extends Beverage {
        @Override
        protected String brew() {
            return "steep tea";
        }

        @Override
        protected String condiment() {
            return "add lemon";
        }
    }
}
