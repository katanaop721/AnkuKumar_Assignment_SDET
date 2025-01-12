
# AnkuKumar_Assignment_SDET

## Prerequisites
Before running the tests, make sure the following are installed on your machine:

- **Java**: Java 8 or higher
- **Maven**: Apache Maven
- **WebDriver**: ChromeDriver or any other browser driver (matching the browser version you intend to use)
- **Browser**: Google Chrome or any supported browser

## Setup

### Step 1: Clone the Repository
Clone the repository to your local machine using the following command:

```bash
git clone https://github.com/katanaop721/AnkuKumar_Assignment_SDET.git
cd AnkuKumar_Assignment_SDET
```

### Step 2: Install Dependencies
Run the following Maven command to download and install the project dependencies:

```bash
mvn clean install
```

### Step 3: Run the Tests
To run the specific `TC01_EndToEnd` test, use the following command:

```bash
mvn -Dtest=TC01_EndToEnd test
```
