package seyerlein.fifth;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import seyerlein.ListStringResource;
import seyerlein.ListStringResourceExtension;

import java.util.List;

@ExtendWith(ListStringResourceExtension.class)
class CraneTest
{
    private static final String INIT_FILE = "/fifth/init.txt";
    private static final String STEPS_FILE = "/fifth/steps.txt";

    @Test
    void test(@ListStringResource(INIT_FILE) List<String> initialState, @ListStringResource(STEPS_FILE) List<String> steps)
    {
        Crane crane = new Crane();
        crane.initialize(initialState);
        crane.processSteps(steps);
        Assertions.assertThat(crane.getResult()).isEqualTo("BPCZJLFJW");
    }
}