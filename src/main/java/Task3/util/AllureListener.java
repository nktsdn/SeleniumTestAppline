package Task3.util;

import Task3.steps.BaseSteps;
import org.junit.runner.notification.Failure;
import ru.yandex.qatools.allure.junit.AllureRunListener;

public class AllureListener extends AllureRunListener {

    @Override
    public void testFailure(Failure failure){
        BaseSteps.takeScreenshot();
        super.testFailure(failure);
    }
}
