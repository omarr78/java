``` java


class Download implements Runnable {
    final String fileName;

    Download(String fileName) {
        this.fileName = fileName;
    }

    public void run() {
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep((int) (Math.random() * 500)); // Simulate download time
            } catch (InterruptedException e) {
                System.out.println(fileName + " is interrupted");
            }
            System.out.println(fileName + " downloaded " + i + "%");
        }
        System.out.println(fileName + " download complete!");
    }
}


public class Main {

    public static void main(String[] args) {

        Thread file1 = new Thread(new Download("File 1"));
        Thread file2 = new Thread(new Download("File 2"));
        Thread file3 = new Thread(new Download("File 3"));

        file1.start();
        file2.start();
        file3.start();

    }
}

```

### output

``` output
...
...
File 2 downloaded 99%
File 1 downloaded 91%
File 1 downloaded 92%
File 3 downloaded 100%
File 3 download complete!
File 2 downloaded 100%
File 2 download complete!
File 1 downloaded 93%
File 1 downloaded 94%
File 1 downloaded 95%
File 1 downloaded 96%
File 1 downloaded 97%
File 1 downloaded 98%
File 1 downloaded 99%
File 1 downloaded 100%
File 1 download complete!

```
