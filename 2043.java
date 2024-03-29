class Bank {
    long[] balanceArr;
    int n;
    
        public Bank(long[] balance) {
            balanceArr = balance.clone();
            n = balance.length;
        }
        
        public boolean transfer(int account1, int account2, long money) {
            if (account1 >= 1 && account1 <= n && balanceArr[account1-1] >= money && account2 >= 1 && account2 <= n)  {
                balanceArr[account2-1] += money;
                balanceArr[account1-1] -= money;
                return true;
            }
    
            return false;
        }
        
        public boolean deposit(int account, long money) {
            if (account >= 1 && account <= n) {
                balanceArr[account-1] += money;
                return true;
            }
    
            return false;
        }
        
        public boolean withdraw(int account, long money) {
            if (account >= 1 && account <= n && balanceArr[account-1] >= money) {
                balanceArr[account-1] -= money;
                return true;
            }
    
            return false;
        }
    }
    
    /**
     * Your Bank object will be instantiated and called as such:
     * Bank obj = new Bank(balance);
     * boolean param_1 = obj.transfer(account1,account2,money);
     * boolean param_2 = obj.deposit(account,money);
     * boolean param_3 = obj.withdraw(account,money);
     */