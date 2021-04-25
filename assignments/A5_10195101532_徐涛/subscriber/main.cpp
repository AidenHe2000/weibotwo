#include "Screen.h"
#include "Text.h"

using namespace std;

int main() {
    Screen screen;
    Text text;
    screen.subscribe(text);
    text.set("Hello world");
}
