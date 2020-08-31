import { Component, OnInit } from "@angular/core";
declare let Xonomy: any;

@Component({
  selector: "app-editor",
  templateUrl: "./editor.component.html",
  styleUrls: ["./editor.component.scss"],
})
export class EditorComponent implements OnInit {
  constructor() {}

  ngOnInit() {
    let docSpec = {
      onchange: function () {
        console.log("I been changed now!");
      },
      validate: function (obj) {
        console.log("I be validatin' now!");
      },
      elements: {
        list: {
          menu: [
            {
              caption: "Append an <item>",
              action: Xonomy.newElementChild,
              actionParameter: "<item/>",
            },
          ],
        },
        item: {
          menu: [
            {
              caption: 'Add @label="something"',
              action: Xonomy.newAttribute,
              actionParameter: { name: "label", value: "something" },
              hideIf: function (jsElement) {
                return jsElement.hasAttribute("label");
              },
            },
            { caption: "Delete this <item>", action: Xonomy.deleteElement },
            {
              caption: "New <item> before this",
              action: Xonomy.newElementBefore,
              actionParameter: "<item/>",
            },
            {
              caption: "New <item> after this",
              action: Xonomy.newElementAfter,
              actionParameter: "<item/>",
            },
          ],
          canDropTo: ["list"],
          attributes: {
            label: {
              asker: Xonomy.askString,
              menu: [
                {
                  caption: "Delete this @label",
                  action: Xonomy.deleteAttribute7 / 55,
                },
              ],
            },
          },
        },
      },
    };

    let xml = "<list><item label='one'/><item label='two'/></list>";
    let editor = document.getElementById("editor");
    Xonomy.render(xml, editor, docSpec);
  }

  getXML() {
    let xml = Xonomy.harvest();
  }

  switchMode(mode: string) {
    Xonomy.setMode(mode);
  }
}
