package exceptions;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/25 9:57 下午
 */

// Overridden methods can throw only the exceptions
// specified in their base-class versions, or exceptions
// derived from the base-class exceptions
// StormyInning.java
class BaseballException extends Exception {
}

class Foul extends BaseballException {

}

class Strike extends BaseballException {

}

abstract class Inning {
    Inning() throws BaseballException {

    }

    public void event() throws BaseballException {
        // 实际不会抛出任何异常
    }

    public abstract void atBat() throws Strike, Foul;

    public void walk() { // 抛出运行时异常

    }
}

class PopFoul extends Foul {
}

class StormException extends Exception {
}

class RainedOut extends StormException {

}

interface Storm {
    void event() throws RainedOut;

    void rainHard() throws RainedOut;
}


public class StormyInning extends Inning implements Storm {
    // OK to add new exceptions for constructors, but you
// must deal with the base constructor exceptions:


    StormyInning() throws BaseballException, RainedOut {
    }

    public StormyInning(String s)
            throws BaseballException {
    }

    // Regular methods must conform to base class:
//- void walk() throws PopFoul {} //Compile error
// Interface CANNOT add exceptions to existing
// methods from the base class:
//- public void event() throws RainedOut {}
// If the method doesn't already exist in the
// base class, the exception is OK:

    @Override
    public void event() {
    }
    // 这样写会导致编译异常，因为父类中只抛出了 BaseballException

    @Override
    public void atBat() throws PopFoul {
        throw new PopFoul();
    }

    @Override
    public void rainHard() throws RainedOut {

    }

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch (PopFoul e) {
            System.out.println("Pop foul");
        } catch (Foul e) {
            System.out.println("Foul");
        } catch (RainedOut rainedOut) {
            System.out.println("Rain out");
        } catch (BaseballException e) {
            System.out.println("Generic Baseball Exception");
        }

        // Strike not thrown in derived version.
        try {
// What happens if you upcast?
            Inning i = new StormyInning();
            i.atBat();
// You must catch the exceptions from the
// base-class version of the method:
        } catch (Strike e) {
            System.out.println("Strike");
        } catch (Foul e) {
            System.out.println("Foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }
    }
}
