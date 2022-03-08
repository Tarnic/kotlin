class BankAccount {
    // TODO: implement read access to 'balance'
    private var open = true;
    var balance: Long = 0                   // we use custom getter and private setter to check if the account is open before setting or returning the balance 
        get() { check(open); return field}  // check(bool) throws IllegalStateException if bool is false
        private set                         // we can't modify the balance value but using the adjustBalance function

    fun adjustBalance(amount: Long){
        check(open)
        synchronized(this) {                // synchronized function implements a lock to avoid multiple access in the critical section
            balance += amount
        }
    }

    fun close() {
        open = false;
    }
}
