package com.solvd.delivery.enums;

public class Order {
    private OrderStatus status;

//    public enum OrderStatus {
//        ORDERED(5) {
//            @Override
//            public boolean isOrdered() {
//                return true;
//            }
//        },
//        READY(2) {
//            @Override
//            public boolean isReady() {
//                return true;
//            }
//        },
//        DELIVERED(0) {
//            @Override
//            public boolean isDelivered() {
//                return true;
//            }
//        };
//
//        private int timeToDelivery;
//
//        public boolean isOrdered() {
//            return false;
//        }
//
//        public boolean isReady() {
//            return false;
//        }
//
//        public boolean isDelivered() {
//            return false;
//        }
//
//
//        public int getTimeToDelivery() {
//            return timeToDelivery;
//        }
//
//        OrderStatus(int timeToDelivery) {
//            this.timeToDelivery = timeToDelivery;
//        }
//
//    }


    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public boolean isDeliverable() {
        return Order.this.status.isReady();
//        return OrderStatus.OrderStatus.ORDERED.isReady();
    }

    public void printTimeToDeliver() {
        System.out.println("Time to deliver is " +
                Order.this.status.getTimeToDelivery());
//                this.getStatus().getTimeToDelivery());
    }

    // Methods that set and get the status variable.
}
