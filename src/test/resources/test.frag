#version 330 core
out vec4 fragColor;

uniform float time;

void main()
{
	fragColor = vec4(sin(time));
}
