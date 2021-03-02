package ru.job4j.warcraftlite;

public class Account {
        private int priority;
        private int health;
        private int attack;

        public Account(int priority, int health, int attack) {
            this.priority = priority; //requisite
            this.health = health; //balance
            this.attack = attack;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public int getAttack() {
            return attack;
        }

        public void setAttack(int attack) {
            this.attack = attack;
        }
    }
