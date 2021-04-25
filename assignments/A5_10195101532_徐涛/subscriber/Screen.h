//
// Created by Admin on 2021/4/25.
//

#ifndef XUTAO_SCREEN_H
#define XUTAO_SCREEN_H

#include <string>

class Text;

class Screen {
public:
    void on_text_change(const std::string &text);

    void subscribe(Text &text);
};


#endif //XUTAO_SCREEN_H
