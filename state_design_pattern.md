# Problem
1. loan entity has state transitions: pending,validated, onhold, disbursed
2. state specific behaviors:
   on reaching pending => assign to validator
   on reaching disbursed => add disbursal date
   on reaching validated => change two params
3. Transfers possible are : 
       Pending -> validated
       Validated -> pending
       Pending -> onHold
       Validated ->onHold
       onHold -> Pending
       Validated ->disbursed
  	   Disbursed is our terminal state

# Scala design - state design pattern
trait LoanState {
	// validate state transition
	def validateTransition(Loan loan) throws InvalidStateTransitionException;
	// invoke actions	
	def stateTriggeredAction(Loan loan)
}

class Loan {
	LoanState currentState;

	void transitionToState(LoanState newState) throws InvalidStateTransitionException {
		newState.validateTransition(this);
		newState.stateTriggeredAction();
	}
}
