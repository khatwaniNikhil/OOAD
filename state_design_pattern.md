# References
https://refactoring.guru/design-patterns/state
https://medium.com/nerd-for-tech/the-super-state-design-pattern-166127ce7c9a
https://www.baeldung.com/spring-state-machine


# Sample Problem
1. loan entity has state transitions: pending,validated, onhold, disbursed
2. state specific behaviors:
    1. on reaching pending => assign to validator
    2. on reaching disbursed => add disbursal date
    3. on reaching validated => change two params
4. Transfers possible are : 
       Pending -> validated
       Validated -> pending
       Pending -> onHold
       Validated ->onHold
       onHold -> Pending
       Validated ->disbursed
  	   Disbursed is our terminal state

# Scala design - state design pattern
```
trait LoanState {
   // validate state transition
   def validateTransition(Loan loan) throws InvalidStateTransitionException;
   // invoke actions
   def stateTriggeredAction(Loan loan)
}
```

```
class Loan {
	LoanState currentState;

	void transitionToState(LoanState newState) throws InvalidStateTransitionException {
		newState.validateTransition(this);
		newState.stateTriggeredAction();
	}
}
```
