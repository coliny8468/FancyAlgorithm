class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack = new Stack<>();
        for (int star : asteroids) {
            if (stack.isEmpty()) {
                stack.push(star);
            } else if (isPlus(stack.peek()) == isPlus(star)) {
                stack.push(star);
            } else {
                if (!isPlus(stack.peek())) {
                    stack.push(star);
                    continue;
                }
                boolean isExplode = false;
                while(isPlus(stack.peek()) != isPlus(star)) {
                    if (Math.abs(stack.peek()) > Math.abs(star)) {
                        isExplode = true;
                        break;
                    } else if (Math.abs(stack.peek()) < Math.abs(star)) {
                        stack.pop();
                    } else {
                        stack.pop();
                        isExplode = true;
                        break;
                    }
                    if (stack.isEmpty()) {
                        break;
                    }
                }

                if (!isExplode) {
                    stack.push(star);
                }
            }
        }

        int size = stack.size();
        int[] answer = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }

    public boolean isPlus(int target) {
        if (target > 0) {
            return true;
        } else {
            return false;
        }
    }
}
