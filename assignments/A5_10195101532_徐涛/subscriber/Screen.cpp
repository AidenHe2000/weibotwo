//
// Created by Admin on 2021/4/25.
//

#include "Screen.h"
#include <iostream>
#include "Text.h"

void Screen::on_text_change(const std::string &text) {
    std::cout << text << std::endl;
}

void Screen::subscribe(Text &text) {
    text.subscribers.push_back(this);
}
