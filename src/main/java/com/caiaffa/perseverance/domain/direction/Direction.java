package com.caiaffa.perseverance.domain.direction;

import com.caiaffa.perseverance.domain.position.Position;

public enum Direction {
    N {

        @Override
        public Direction left() {
            return Direction.W;
        }

        @Override
        public Direction right() {
            return Direction.E;
        }

        @Override
        public Position move() {
            return new Position(0,1);
        }
    },

    W {
        @Override
        public Direction left() {
            return Direction.S;
        }

        @Override
        public Direction right() {
            return Direction.N;
        }

        @Override
        public Position move() {
            return new Position(-1,0);
        }
    },

    S {
        @Override
        public Direction left() {
            return Direction.E;
        }

        @Override
        public Direction right() {
            return Direction.W;
        }

        @Override
        public Position move() {
            return new Position(0,-1);
        }
    },

    E {
        @Override
        public Direction left() {
            return Direction.N;
        }

        @Override
        public Direction right() {
            return Direction.S;
        }

        @Override
        public Position move() {
            return new Position(1, 0);
        }
    };

    public abstract Direction right();
    public abstract Direction left();
    public abstract Position move();

}
