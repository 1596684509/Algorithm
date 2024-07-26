package LeetCode.Easy;

public class E225 {

    private Note head = new Note(null, 0);

    public E225() {

    }

    public void push(int x) {

        if(empty()) {

            head.next = new Note(null, x);

        }else {

            head.next = new Note(head.next, x);

        }

    }

    public int pop() {

        if(!empty()) {

            int v = head.next.value;
            head.next = head.next.next;
            return v;

        }

        return 0;
    }

    public int top() {

        if(!empty()) {

            return head.next.value;

        }

        return 0;

    }

    public boolean empty() {

        if(head.next == null) {

            return true;

        }

        return false;

    }

    private static class Note {

        private Note next;
        private int value;

        public Note(Note next, int value) {

            this.next = next;
            this.value = value;

        }

    }

}
