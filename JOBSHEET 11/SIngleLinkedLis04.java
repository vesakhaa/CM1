import org.w3c.dom.Node;

public class SIngleLinkedLis04 {
    Node04 head;
    Node04 tail;

    boolean isEmpty() {
        return head == null;
    }

    public void print() {
        if (!isEmpty()){
            Node04 tmp = head;
            System.out.println("Isi Lnked List : ");
            while (tmp != null) {
                tmp.data.tampilInformasi();
                tmp = tmp.next;
            }
            System.out.println(" ");
        } else {
            System.out.println("Linked List Kosong");
        }
    }

    public void addFirst(Mhs04 input) {
        Node04 ndInput = new Node04(input, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            ndInput.next = head;
            head = ndInput;
        }
    }

    public void addLast(Mhs04 input) {
        Node04 ndInput = new Node04(input, null);
        if(isEmpty()){
            head = ndInput;
            tail = ndInput;
        }else {
            tail.next = ndInput;
            tail = ndInput;
        }
    }

    public void insertAfter(String key, Mhs04 input) {
        Node04 ndInput = new Node04(input, null);
        Node04 temp = head;
        do {
            if(temp.data.nama.equalsIgnoreCase(key)) {
                ndInput.next = temp.next;
                temp.next = ndInput;
                if(ndInput.next == null){
                    tail = ndInput;
                }
                break;
            }
            temp = temp.next;
        } while (temp != null);
    }

    public void insertAt(int index, Mhs04 input) {
        if (index < 0){
            System.out.println("Indeks Salah");
        } else if (index == 0) {
            addFirst(input);
        } else {
            Node04 temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = new Node04(input, temp.next);
            if (temp.next.next == null) {
                tail = temp.next;
            }
        }
    }
    
    public void getData(int index) {
        Node04 tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        tmp.data.tampilInformasi();
    }

    public int indexOf(String key) {
        Node04 tmp = head;
        int index = 0;
        while (tmp != null && !tmp.data.nama.equalsIgnoreCase(key)){
            tmp = tmp.next;
            index++;
        }

        if(tmp == null){
            return -1;
        }else {
            return index;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List Masih Kosong, tidak dapat dihapus!");

            //data ada 1
        } else if (head == tail) { 
            head = tail = null;

            //data lebih dari 1
        } else {
            head = head.next;
        }
    }

    public void removeLast() {
        if(isEmpty()){
            System.out.println("Linked List Masih Kosong, tidak dapat dihapus!");

            //data ada 1
        } else if (head == tail) {
            head = tail = null;

            //data lebih dari 1
        } else {
            Node04 temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
    }

    public void remove(String key) {
        if (isEmpty()) {
            System.out.println("Linked List Masih Kosong, tidak dapat dihapus!");
        } else {
            Node04 temp = head;
            while (temp != null) {
                if ((temp.data.nama.equalsIgnoreCase(key)) && (temp == head)) {
                    this.removeFirst();
                    break;
                }
                else if (temp.data.nama.equalsIgnoreCase(key)) {
                    temp.next = temp.next.next;
                    if(temp.next == null){
                        tail = temp;
                    }
                    break;
                } 
                temp = temp.next;
            }
        }   
    }

    public void removeAt(int index) {
        if(index == 0){
            removeFirst();
        } else{
            Node04 temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if(temp.next == null){
                tail = temp;
            }
        }
    }
}
