//
// Created by Admin on 2021/4/25.
//

#include "Text.h"
#include "Screen.h"

void Text::set(const std::string &a) {
    text = a;
    for (auto i : subscribers) {
        i->on_text_change(text);
    }

}
