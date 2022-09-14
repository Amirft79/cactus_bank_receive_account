package ir.cactus.util;

public enum AccountType {
    Saving{
        @Override
        public String toString() {
            return "Saving";
        }
    },
    RecurringDeposit{
        @Override
        public String toString() {
            return "RecurringDeposit";
        }
    },
    FixedDepositAccount{
        @Override
        public String toString() {
            return "FixedDepositAccount";
        }
    }
}
