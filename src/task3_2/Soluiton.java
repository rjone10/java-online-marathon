package task3_2;


public class Soluiton {
    static class NameList {
        private String[] names = {"Mike", "Emily", "Nick", "Patric", "Sara"};

        public Iterator getIterator() {
            return new Iterator();
        }

        public class Iterator {
            private int counter = 0;

            private Iterator() {
            }

            public boolean hasNext() {
                return this.counter < names.length;
            }

            public String next() {
                counter++;
                return names[counter - 1];
            }
        }

    }

    public static void main(String[] args) {
        for (NameList.Iterator iterator = new NameList().getIterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }
}
