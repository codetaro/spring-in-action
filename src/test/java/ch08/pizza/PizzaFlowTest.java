package ch08.pizza;

import ch08.pizza.domain.Customer;
import ch08.pizza.flow.PizzaFlowActions;
import ch08.pizza.service.CustomerNotFoundException;
import org.junit.Ignore;
import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;
import org.springframework.webflow.test.MockExternalContext;
import org.springframework.webflow.test.MockFlowBuilderContext;
import org.springframework.webflow.test.execution.AbstractXmlFlowExecutionTests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//@Ignore("Need to write individual tests for each subflow and test top-level flow with mock flows.")
public class PizzaFlowTest extends AbstractXmlFlowExecutionTests {

    @Override
    protected FlowDefinitionResource getResource(FlowDefinitionResourceFactory resourceFactory) {
        return resourceFactory.createResource("file:src/main/webapp/WEB-INF/flows/pizza/pizza-flow.xml");
    }

    @Override
    protected void configureFlowBuilderContext(MockFlowBuilderContext builderContext) {
        PizzaFlowActions pizzaFlowActions = mock(PizzaFlowActions.class);
        try {
            when(pizzaFlowActions.lookupCustomer("9725551234")).thenReturn(new Customer("9725551234"));
            when(pizzaFlowActions.lookupCustomer("5051231234")).thenThrow(new CustomerNotFoundException());
        } catch (CustomerNotFoundException e) {
//            e.printStackTrace();
        }

        builderContext.registerBean("pizzaFlowActions", pizzaFlowActions);
    }

    public void testStartPizzaFlow() {
        startFlow(new MockExternalContext());
        assertCurrentStateEquals("welcome");
    }

}
