//
// Created by Admin on 2021/4/25.
//

#include "Speaker.h"
#include <iostream>

Speaker *Speaker::singleton = nullptr;

const Speaker &Speaker::getInstance() {
    if (Speaker::singleton == nullptr)
        Speaker::singleton = new Speaker;
    return *singleton;
}

void Speaker::speak() const {
    using namespace std;
    cout << "Hello world" << endl;
}