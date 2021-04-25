//
// Created by Admin on 2021/4/25.
//

#ifndef XUTAO_TEXT_H
#define XUTAO_TEXT_H

#include <vector>
#include <string>

class Screen;

class Text {
    std::string text;
    std::vector<Screen *> subscribers;
public:
    friend Screen;

    void set(const std::string &a);
};


#endif //XUTAO_TEXT_H
